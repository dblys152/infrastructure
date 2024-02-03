# infrastructure

### 공통 유틸 라이브러리로 사용하고 있는 프로젝트입니다.

### Using The Library
1. maven { url 'https://jitpack.io' } 추가


    allprojects {
        repositories {
            mavenCentral()
            maven { url 'https://jitpack.io' }
        }
    }

2. 의존성 추가

    
    dependencies {
        implementation 'com.github.dblys152:infrastructure:1.0.5'
    }

