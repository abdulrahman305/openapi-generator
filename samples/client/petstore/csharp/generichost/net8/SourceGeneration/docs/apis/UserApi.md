# Org.OpenAPITools.Api.UserApi

All URIs are relative to *http://petstore.swagger.io:80/v2*

| Method | HTTP request | Description |
|--------|--------------|-------------|
| [**CreateUser**](UserApi.md#createuser) | **POST** /user | Create user |
| [**CreateUsersWithArrayInput**](UserApi.md#createuserswitharrayinput) | **POST** /user/createWithArray | Creates list of users with given input array |
| [**CreateUsersWithListInput**](UserApi.md#createuserswithlistinput) | **POST** /user/createWithList | Creates list of users with given input array |
| [**DeleteUser**](UserApi.md#deleteuser) | **DELETE** /user/{username} | Delete user |
| [**GetUserByName**](UserApi.md#getuserbyname) | **GET** /user/{username} | Get user by user name |
| [**LoginUser**](UserApi.md#loginuser) | **GET** /user/login | Logs user into the system |
| [**LogoutUser**](UserApi.md#logoutuser) | **GET** /user/logout | Logs out current logged in user session |
| [**UpdateUser**](UserApi.md#updateuser) | **PUT** /user/{username} | Updated user |

<a id="createuser"></a>
# **CreateUser**
> void CreateUser (User user)

Create user

This can only be done by the logged in user.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class CreateUserExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "http://petstore.swagger.io:80/v2";
            var apiInstance = new UserApi(config);
            var user = new User(); // User | Created user object

            try
            {
                // Create user
                apiInstance.CreateUser(user);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling UserApi.CreateUser: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the CreateUserWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Create user
    apiInstance.CreateUserWithHttpInfo(user);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling UserApi.CreateUserWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **user** | [**User**](User.md) | Created user object |  |

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **0** | successful operation |  -  |

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

<a id="createuserswitharrayinput"></a>
# **CreateUsersWithArrayInput**
> void CreateUsersWithArrayInput (List<User> user)

Creates list of users with given input array

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class CreateUsersWithArrayInputExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "http://petstore.swagger.io:80/v2";
            var apiInstance = new UserApi(config);
            var user = new List<User>(); // List<User> | List of user object

            try
            {
                // Creates list of users with given input array
                apiInstance.CreateUsersWithArrayInput(user);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling UserApi.CreateUsersWithArrayInput: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the CreateUsersWithArrayInputWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Creates list of users with given input array
    apiInstance.CreateUsersWithArrayInputWithHttpInfo(user);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling UserApi.CreateUsersWithArrayInputWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **user** | [**List&lt;User&gt;**](User.md) | List of user object |  |

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **0** | successful operation |  -  |

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

<a id="createuserswithlistinput"></a>
# **CreateUsersWithListInput**
> void CreateUsersWithListInput (List<User> user)

Creates list of users with given input array

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using Org.OpenAPITools.Client;
using Org.OpenAPITools.Model;

namespace Example
{
    public class CreateUsersWithListInputExample
    {
        public static void Main()
        {
            Configuration config = new Configuration();
            config.BasePath = "http://petstore.swagger.io:80/v2";
            var apiInstance = new UserApi(config);
            var user = new List<User>(); // List<User> | List of user object

            try
            {
                // Creates list of users with given input array
                apiInstance.CreateUsersWithListInput(user);
            }
            catch (ApiException  e)
            {
                Debug.Print("Exception when calling UserApi.CreateUsersWithListInput: " + e.Message);
                Debug.Print("Status Code: " + e.ErrorCode);
                Debug.Print(e.StackTrace);
            }
        }
    }
}
```

#### Using the CreateUsersWithListInputWithHttpInfo variant
This returns an ApiResponse object which contains the response data, status code and headers.

```csharp
try
{
    // Creates list of users with given input array
    apiInstance.CreateUsersWithListInputWithHttpInfo(user);
}
catch (ApiException e)
{
    Debug.Print("Exception when calling UserApi.CreateUsersWithListInputWithHttpInfo: " + e.Message);
    Debug.Print("Status Code: " + e.ErrorCode);
    Debug.Print(e.StackTrace);
}
```

### Parameters

| Name | Type | Description | Notes |
|------|------|-------------|-------|
| **user** | [**List&lt;User&gt;**](User.md) | List of user object |  |

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **0** | successful operation |  -  |

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

<a id="deleteuser"></a>
# **DeleteUser**
> void DeleteUser (string username)

Delete user

This can only be done by the logged in user.

### Example
```csharp
using System.Collections.Generic;
using System.Diagnostics;
using Org.OpenAPITools.Api;
using