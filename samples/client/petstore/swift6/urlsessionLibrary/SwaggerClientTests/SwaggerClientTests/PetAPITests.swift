//
//  PetAPITests.swift
//  SwaggerClient
//
//  Created by Robin Eggenkamp on 5/21/16.
//  Copyright © 2016 Swagger. All rights reserved.
//

import PetstoreClient
import XCTest
@testable import SwaggerClient

@MainActor
class PetAPITests: XCTestCase {

    let testTimeout = 10.0

    override func setUp() {
        super.setUp()
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }

    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
        super.tearDown()
    }

    func test1CreatePet() {
        let expectation = self.expectation(description: "testCreatePet")
        let category = PetstoreClientAPI.Category(id: 1234, name: "eyeColor")
        let tags = [PetstoreClientAPI.Tag(id: 1234, name: "New York"), PetstoreClientAPI.Tag(id: 124321, name: "Jose")]
        let newPet = PetstoreClientAPI.Pet(id: 1000, category: category, name: "Fluffy", photoUrls: ["https://petstore.com/sample/photo1.jpg", "https://petstore.com/sample/photo2.jpg"], tags: tags, status: .encodeValue(.available))

        PetstoreClientAPI.PetAPI.addPet(body: newPet) { (_, error) in
            guard error == nil else {
                XCTFail("error creating pet")
                return
            }

            expectation.fulfill()
        }

        self.waitForExpectations(timeout: testTimeout, handler: nil)
    }

    func test2GetPet() {
        let expectation = self.expectation(description: "testGetPet")

        PetstoreClientAPI.PetAPI.getPetById(petId: 1000) { (pet, error) in
            guard error == nil else {
                XCTFail("error retrieving pet")
                return
            }

            if let pet = pet {
                XCTAssert(pet.id == 1000, "invalid id")
                XCTAssert(pet.name == "Fluffy", "invalid name")

                expectation.fulfill()
            }
        }

        self.waitForExpectations(timeout: testTimeout, handler: nil)
    }

    func test3UploadFile() {
        let expectation = self.expectation(description: "testUploadFile")

        let imageName = UUID().uuidString + ".png"

        guard
            let image = UIImage(color: .red, size: CGSize(width: 10, height: 10)),
            let imageURL = FileUtils.saveImage(imageName: imageName, image: image)
        else {
            fatalError()
        }

        PetstoreClientAPI.PetAPI.uploadFile(petId: 1000, additionalMetadata: "additionalMetadata", file: imageURL) { (_, error) in
            guard error == nil else {
                FileUtils.deleteFile(fileURL: imageURL)
                XCTFail("error uploading file")
                return
            }

            FileUtils.deleteFile(fileURL: imageURL)
            expectation.fulfill()
        }

        self.waitForExpectations(timeout: testTimeout, handler: nil)
    }

    func test4DeletePet() {
        let expectation = self.expectation(description: "testDeletePet")

        PetstoreClientAPI.PetAPI.deletePet(petId: 1000) { (_, error) in
            guard error == nil else {
                XCTFail("error deleting pet")
                return
            }

            expectation.fulfill()
        }

        self.waitForExpectations(timeout: testTimeout, handler: nil)
    }

}
