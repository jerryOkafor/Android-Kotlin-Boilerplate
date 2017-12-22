![](./Kotlin_logo_image_picture.png)

# Android-Kotlin-Boilerplate

[![Build Status](https://travis-ci.org/po10cio/Android-Kotlin-Boilerplate.svg?branch=master)](https://travis-ci.org/po10cio/Android-Kotlin-Boilerplate)
[![Coverage](https://img.shields.io/codecov/c/github/po10cio/Android-Kotlin-Boilerplate/master.svg)](https://codecov.io/gh/po10cio/Android-Kotlin-Boilerplate) 
[![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)](https://github.com/ellerbrock/open-source-badge/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/po10cio/Android-Kotlin-Boilerplate/blob/master/LICENSE.md) 

This project demonstrates Android Architecture Components (Viewodel, Livedata) and Dagger for dependency Injection in Kotlin.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. You can then modify the project app id or build 

## What you can learn from this repo

- How to implement `UI tests(Instrumentation)` using Espresso and `logic tests (Unit test)` using JUnit4.
- Fundamental Kotlin language and basic usage.
- Continuous Integration with Travis ci.

## Library version

- Buils Tools Version:27.0.2
- Compile SDK Version: 27
- Target SDK version: 27
- Support Version: 27.0.2
- Android Architecture version: 1.0.0
- Dagger version: 2.12
- Retrofit Version: 2.3.0
- Kotlin: 1.2.10
- RxKotlin: 2.2.0
- Espresso: 3.0.1 (espresso-core)


### Prerequisites

You need AndroidStudio 3.0 or higher to run this project.

```
git clone https://github.com/po10cio/Android-Kotlin-Boilerplate.git

```
Then use Android Studio to import the project.

Alternativly, you can click on File -> New -> Project from version control -> Github and then paste the url above and let Android Studio clone and import the project for you.

### Directory Structure
```
src----
   |--data
   |--di
   |--model
   |--ui
   |--util
   |--viewmodel


```

### Directory Description
## data
The data package contains the datasource interface and the Repository which implements the interface.

* DataSource : This is the data source contracta that any possible datasource for our app must implement
* Repository: A simple implementation of the Datasource interface.

## di
This package conatains all the dependency intergration stuff which  inclucde the 


* AppComponent: Combines all the app modules and inejct it into the app

* AppInjector: Used to dynamically init the App Components and inject activity and fragments
* AppModule: Contains injection for the application specif modules
* BuildersModule: Provides all the components and subcomponents necessary for inejecting int Fragments and activity.
* Injectable: A simple interface used to indicate that a fragment is injecatble
* PerActivity: Interface used to scope dependencies to activity.
* PerChildFragment: Interface used to scope dependencies to the ChildFrgaments in the case of nested  Fragments
* Fragment Scopes : Interface used to scope dependencies to Fragments
* ViewmodelKey : Dagger binding key for ViewModels
* ViewModelModules: Provides injectors for the Android Achiteacture Component ViewModoel.

### model
This package holds all the models for our app which one of them at the momnent is User

### ui
This packge holds the Fragments, Activities and the viewModels

### util
This package holds all the utility files thate we may need from time to time.

## Note:
The contents of this project and the pacakges organisations are personal opinion adns it is not any standard by any authority. If you have a different opinion, feel free to share it so that we can make the cahnges.

## Authors

* **Jerry Hanks Okafor**  - [Po10cio](https://github.com/Po10cio)

See also the list of [contributors](https://github.com/Android-Kotlin-Boilerplate/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* [Google Samples](https://github.com/googlesamples/android-architecture-components)
