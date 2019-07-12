# EasyToast
EasyToast

1.Gradle


Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.lilongweidev:EasyToast:0.1'
	}
  
2.Maven


Step 1. Add the JitPack repository to your build file

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  
Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.lilongweidev</groupId>
	    <artifactId>EasyToast</artifactId>
	    <version>Tag</version>
	</dependency>




Usage

	//不带动画
	EasyToast.showLongToast(getApplicationContext(),"长消息");
	
	EasyToast.showShortToast(getApplicationContext(),"短消息");
	
	//带动画表情
        EasyToast.showShortSuccessToast(getApplicationContext(),"成功");
    
   	
        EasyToast.showShortWarningToast(getApplicationContext(),"警告");
    
 
        EasyToast.showShortErrorToast(getApplicationContext(),"错误");
    
  
        EasyToast.showShortInfoToast(getApplicationContext(),"信息");
    
 
        EasyToast.showShortDefaultToast(getApplicationContext(),"默认");
    

        EasyToast.showShortConfusingToast(getApplicationContext(),"困惑");
	
	
    


  

  
  
