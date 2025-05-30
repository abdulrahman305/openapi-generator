/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 *
 * Contact: team@openapitools.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 *
 * https://openapi-generator.tech
 */

// this model was generated using modelTest.mustache
package sample.cask.model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import scala.util.*

class SomeResponse1Test extends AnyWordSpec with Matchers {


    "SomeResponse1.fromJson" should {
        """not parse invalid json""" in {
           val Failure(err) = Try(SomeResponse1Data.fromJsonString("invalid jason"))
           err.getMessage should startWith ("Error parsing json 'invalid jason'")
        }
        """parse """ ignore {
           val d8a = SomeResponse1Data.fromJsonString("""""")
           val Failure(err : ValidationErrors) = SomeResponse1Data.validated(d8a, true)

           sys.error("TODO")
        }
    }
}
