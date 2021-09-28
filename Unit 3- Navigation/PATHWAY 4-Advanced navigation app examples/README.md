# PATHWAY 4: Advanced navigation app examples
[PATHWAY 4 사이트](https://developer.android.com/courses/pathways/android-basics-kotlin-unit-3-pathway-4)

## 1. Cupcake app introduction
이번 유닛에 배웠던 내용들을 종합적으로 합쳐 컵케이크에 관한 앱을 만들어본다.</br>
컵케이크 주문 과정이 있고, 사용자가 컵케이크 주문의 수량, 맛과 수령날짜를 선택할 수 있다.</br>
또한, 백 스택을 수정하는 방법도 배운다. 예를 들어 취소 버튼을 누르면 현재 주문을 취소하고 첫 화면으로 돌아가 새로운 주문을 하게한다.

## 2. Shared ViewModel
[Fragment간 ViewModel 공유하기](https://developer.android.com/codelabs/basic-android-kotlin-training-shared-viewmodel?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-3-pathway-4%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-shared-viewmodel#0)

이전 활동에서 Activity, Fragment, Intent, Data Binding, Jetpack Navigation Component, Architecture components의 사용 방법을 알아봤다.</br>
이번에는 위의 내용을 종합하고 Shared ViewModel을 사용하여 동일한 Activity의 Fragment 간에 데이터를 공유하는 방법 및 LiveData 변환과 같은 새로운 개념을 컵케이크 주문 앱을 개발해보면서 알아보자.