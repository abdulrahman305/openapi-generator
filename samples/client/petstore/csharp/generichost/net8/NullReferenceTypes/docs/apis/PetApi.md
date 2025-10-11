# Org.OpenAPITools.Api.PetApi

All URIs are relative to *http://petstore.swagger.io:80/v2*

| Method | HTTP request | Description |
|--------|--------------|-------------|
| [**AddPet**](PetApi.md#addpet) | **POST** /pet | Add a new pet to the store |
| [**DeletePet**](PetApi.md#deletepet) | **DELETE** /pet/{petId} | Deletes a pet |
| [**FindPetsByStatus**](PetApi.md#findpetsbystatus) | **GET** /pet/findByStatus | Finds Pets by status |
| [**FindPetsByTags**](PetApi.md#findpetsbytags) | **GET** /pet/findByTags | Finds Pets by tags |
| [**GetPetById**](PetApi.md#getpetbyid) | **GET** /pet/{petId} | Find pet by ID |
| [**UpdatePet**](PetApi.md#updatepet) | **PUT** /pet | Update an existing pet |
| [**UpdatePetWithForm**](PetApi.md#updatepetwithform) | **POST** /pet/{petId} | Updates a pet in the store with form data |
| [**UploadFile**](PetApi.md#uploadfile) | **POST** /pet/{petId}/uploadImage | uploads an image |
| [**UploadFileWithRequiredFile**](PetApi.md#uploadfilewithrequiredfile) | **POST** /fake/{petId}/uploadImageWithRequiredFile | uploads an image (required) |

<a id="addpet"></a>
# **AddPet**
> void AddPet (Pet pet)

Add a new pet to the store

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class AddPetExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "http://petstore.swagger.io:80/v2";
            // Configure OAuth2 access token for authorization: petstore_auth
            config.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new PetApi(config);
            var pet = new Pet(); // Pet | Pet object that needs to be added to the store

            try
            {
                // Add a new pet to the store
                apiInstance.AddPet(pet);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling PetApi.AddPet: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the AddPetWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Add a new pet to the store
    apiInstance.AddPetWithHttpInfo(pet);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling PetApi.AddPetWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **pet** | [**Pet**](Pet.md) | Pet object that needs to be added to the store |  |

### Return type

void (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth), [http_signature_test](../README.md#http_signature_test)

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **405** | Invalid input |  -  |

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

<a id="deletepet"></a>
# **DeletePet**
> void DeletePet (long petId, string apiKey = null)

Deletes a pet

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class DeletePetExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "http://petstore.swagger.io:80/v2";
            // Configure OAuth2 access token for authorization: petstore_auth
            config.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new PetApi(config);
            var petId = 789L;  // long | Pet id to delete
            var apiKey = "apiKey_example";  // string |  (optional) 

            try
            {
                // Deletes a pet
                apiInstance.DeletePet(petId, apiKey);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling PetApi.DeletePet: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the DeletePetWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Deletes a pet
    apiInstance.DeletePetWithHttpInfo(petId, apiKey);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling PetApi.DeletePetWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **petId** | **long** | Pet id to delete |  |
| **apiKey** | **string** |  | [optional]  |

### Return type

void (empty response body)

### Authorization

[petstore_auth](../README.md#petstore_auth)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **400** | Invalid pet value |  -  |

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

<a id="findpetsbystatus"></a>
# **FindPetsByStatus**
> List&lt;Pet&gt; FindPetsByStatus (List<string> status)

Finds Pets by status

Multiple status values can be provided with comma separated strings

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class FindPetsByStatusExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "http://petstore.swagger.io:80/v2";
            // Configure OAuth2 access token for authorization: petstore_auth
            config.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new PetApi(config);
            var status = new List<string>(); // List<string> | Status values that need to be considered for filter

            try
            {
                // Finds Pets by status
                List<Pet> result = apiInstance.FindPetsByStatus(status);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling PetApi.FindPetsByStatus: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the FindPetsByStatusWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Finds Pets by status
    ApiResponse<List<Pet>> response = apiInstance.FindPetsByStatusWithHttpInfo(status);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling PetApi.FindPetsByStatusWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **status** | [**List&lt;string&gt;**](string.md) | Status values that need to be considered for filter |  |

### Return type

[**List&lt;Pet&gt;**](Pet.md)

### Authorization

[petstore_auth](../README.md#petstore_auth), [http_signature_test](../README.md#http_signature_test)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Invalid status value |  -  |
| **2XX** | Anything within 200-299 |  -  |
| **4XX** | Anything within 400-499 |  -  |

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

<a id="findpetsbytags"></a>
# **FindPetsByTags**
> List&lt;Pet&gt; FindPetsByTags (List<string> tags)

Finds Pets by tags

Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class FindPetsByTagsExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "http://petstore.swagger.io:80/v2";
            // Configure OAuth2 access token for authorization: petstore_auth
            config.AccessToken = "YOUR_ACCESS_TOKEN";

            var apiInstance = new PetApi(config);
            var tags = new List<string>(); // List<string> | Tags to filter by

            try
            {
                // Finds Pets by tags
                List<Pet> result = apiInstance.FindPetsByTags(tags);
                Debug.WriteLine(result);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling PetApi.FindPetsByTags: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the FindPetsByTagsWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Finds Pets by tags
    ApiResponse<List<Pet>> response = apiInstance.FindPetsByTagsWithHttpInfo(tags);
    Debug.Write("Status Code: " + response.StatusCode);
    Debug.Write("Response Headers: " + response.Headers);
    Debug.Write("Response Body: " + response.Data);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling PetApi.FindPetsByTagsWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **tags** | [**List&lt;string&gt;**](string.md) | Tags to filter by |  |

### Return type

[**List&lt;Pet&gt;**](Pet.md)

### Authorization

[petstore_auth](../README.md#petstore_auth), [http_signature_test](../README.md#http_signature_test)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml, application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Invalid tag value |  -  |

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

<a id="getpetbyid"></a>
# **GetPetById**
> Pet GetPetById (long petId)

Find pet by ID

Returns a single pet

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class GetPetByIdExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "http://petstore.swagger.io:80/v2";
            // Configure API key authorization: api_key
            config.