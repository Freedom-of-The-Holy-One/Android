#### Android系统权限：

   一、正常权限与危险权限

   二、授权

1. 若设备是Android6.0(API级别23)或者更高版本，并且应用的targetSdkVersion是23或更高版本，则应用在运行时向用户请求权限。用户可随时调用权限，因此应用在每次运行时均需要检查自身是否具备所需权限。

2. 若设备是Android5.1(API级别22)或者更低版本，并且应用的targetSdkVersion是22或者更低版本，则系统在用户安装应用时要求用户授予权限。若果新权限添加到更新的版本时，系统会在用户更新应用时要求授予该权限。用户一旦安装应用，他们撤销权限的唯一方式是卸载应用。

   ------

   备注：

   - compileSdkVersion：编译的SDK版本

   - minSdkVersion：应用兼容的最低SDK版本

   - targetSdkVersion：提供向前兼容

     ```
     getApplicationInfo().targetSdkVersion < Buid.XXXX 
     若某API的使用发生变化，或者新增某个API，需要用上述语句判断，从而分别执行变化前后的代码，保证程序兼容性。
     ```

   三、权限组

   1. 如果应用请求其清单中列出的危险权限，而应用目前在权限组中没有任何权限，则系统会向用户显示一个对话框，描述应用要访问的权限组。对话框不描述该组内的具体权限。例如，如果应用请求 READ_CONTACTS 权限，系统对话框只说明该应用需要访问设备的联系信息。如果用户批准，系统将向应用授予其请求的权限。  

   2. 如果应用请求其清单中列出的危险权限，而应用在同一权限组中已有另一项危险权限，则系统会立即授予该权限，而无需与用户进行任何交互。例如，如果某应用已经请求并且被授予了 READ_CONTACTS 权限，然后它又请求 WRITE_CONTACTS，系统将立即授予该权限。

      ------

```
//动态授权代码

```