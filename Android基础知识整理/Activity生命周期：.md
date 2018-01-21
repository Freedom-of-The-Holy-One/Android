#### Activity生命周期：

1. onCreate()------onDestory()：

   onCreate()：执行“全局”状态设置(例如：定义布局)

   onDestory()：销毁Activity

   例如：后台线程网上下载数据

2. onStart()------onStop()：

   这段期间，用户可以在屏幕上看到Activity并且与之交互。

3. onResume()------onPause()：

   这段期间，Activity位于屏幕上所有其他Activity之前，并具有用户输入焦点。

   当设备转入休眠状态或者出现对话框时，系统调用onPause()。

   ​