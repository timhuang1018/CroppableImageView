CroppableImageView
=====
A simple and lightweight library to help create a view object which has cropping ability.
![Demo library in project](https://giphy.com/gifs/lqeNwTe833I54lcMPz)

## Getting started
#### Setup dependency
In app level gradle file add dependency:
```groovy
implementation "com.timhuang:croppableimageview:1.0.4"
```
#### Add view
```xml
    <com.timhuang.cropper.CropImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:scaleType="matrix"/>
```
The scaleType needs to be set into matrix for appropriate cropping result,
you can use attribue ```app:cropShape="oval"``` to display hint and able crop a oval image, default value is rectangle.
Use ```app:cropHintColor="..."```to change the hint color, this only work when shape is set to oval.
#### Crop image
Call ```CropImageView.cropImage()``` at where you want to get the crop image, this api return a bitmap

## License
Copyright 2020, Tim Huang

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.