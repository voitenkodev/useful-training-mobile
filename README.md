## Support Platforms

* Android
* iOS

## Tech Stack

**Client:** Kotlin Multiplatform

* Compose Multiplatform
* Ktor
* Sqldelight
* Decompose
* Moko
* Datastore-preferences
* Ktx DateTime
* Ktx Serialization
* Coroutines + Flow


**Server:** Node

* NestJs



| Route         | Modules                     | Description                                           |
|---------------|-----------------------------|-------------------------------------------------------|
|               | [:androidApp]               | Android launcher (app module)                         |
|               | [:iosApp]                   | iOS launcher (Native iOS project)                     |
|               | [:data]                     | Layer realise domain api using services               |
| common        | [:architecture-component]   | Basic arh components (like common ViewModel)          |
| common        | [:platform-api]             | Basic Multiplatform platform components               |
| common        | [:utils]                    | Validators / common extensions, date utils, etc       |
| compose-libs  | [:charts]                   | Custom charts using canvas api                        |
| compose-libs  | [:compose-image]            | Multiplatform image loader (now col3                  |
| compose-libs  | [:compose-video]            | Multiplatform video player                            |
| compose-libs  | [:height-picker]            | Custom height picker using canvas api                 |
| compose-libs  | [:muscle-picker]            | Custom muscle picker using dynamic image functions    |
| compose-libs  | [:percentage-picker]        | Custom percentage picker using canvas api             |
| compose-libs  | [:weight-picker]            | Custom weight picker using canvas api                 |
| domain        | [:...all...]                | Api for features by Business logic                    |
| features      | [:...all...]                | Features by Business logic                            |
| design-system | [:atom]                     | Atomic values for like colors / palette / paddings    |
| design-system | [:molecule]                 | Basic UI components using atom styles                 |
| design-system | [:components]               | UI prepared Business components                       |
| design-system | [:resources]                | Fonts / Icons / Images / Videos                       |
| services      | [:database]                 | Local DataBase Using sqlDelight                       |
| services      | [:image-core]               | Http image controller + cache controller              |
| services      | [:network]                  | Remote connector to API                               |
| services      | [:preferences]              | Local Preferences [key:value]                         |


## Demo

| **Android App**                                                                                                                       | **iOS App**                                                                                                                      |
|---------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| [<img src="screenshots/android.mov" width="200" height = "431" />](screenshots/android.mov)       | [<img src="screenshots/ios.gif" width="200" height = "431" />](screenshots/ios.gif) |
