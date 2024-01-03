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
|               | [:androidApp]               | Android launcher (app module)                         |
|               | [:iosApp]                   | iOS launcher (Native iOS project)                     |
|               | [:data]                     | Layer realise domain api using services               |
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


## Demo Registration

https://github.com/voitenkodev/useful-training-mobile/assets/93656470/18d57f65-765d-4e39-afc0-e9caac79df3c

https://github.com/voitenkodev/useful-training-mobile/assets/93656470/74feddb1-ca96-4f4e-8b92-8a7071815fc6
