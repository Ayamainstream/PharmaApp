# PharmaApp

PharmaApp is an Android application that allows users to browse and order drugs for delivery to their homes. The app utilizes Java as the programming language and incorporates several key technologies, including Firebase for authentication, Room Database for local data storage, and ViewModel and LiveData for efficient data management and UI updates.

## Features

- User Authentication: Users can create an account or log in to the app using Firebase authentication.
- Drug Catalog: Users can browse through a catalogue of available drugs, view their prices, and select the desired drugs for purchase.
- Ordering Process: Once the user has selected the drugs they wish to purchase, they can proceed to the checkout process.
- Address Input: Users are prompted to enter their home address, which will be used for delivery.
- Delivery Confirmation: The purchase is completed after the drugs are delivered to the user's address, and payment is made directly to the delivery person.

## Screenshots
<img width="306" alt="Screenshot 1" src="https://github.com/Ayamainstream/PharmaApp/assets/72498812/7cd59133-c1d7-4691-a2b5-740a14f1433d">
<img width="306" alt="Screenshot 2" src="https://github.com/Ayamainstream/PharmaApp/assets/72498812/bf32195e-95e4-46d9-9306-a2e0bffe726d">
<img width="306" alt="Screenshot 3" src="https://github.com/Ayamainstream/PharmaApp/assets/72498812/7a3acc63-88ee-4326-88bc-6217fcc4d602">
<img width="306" alt="Screenshot 4" src="https://github.com/Ayamainstream/PharmaApp/assets/72498812/d0f87a8b-ff8f-4162-bd08-a41dac022104">
<img width="306" alt="Screenshot 5" src="https://github.com/Ayamainstream/PharmaApp/assets/72498812/455ff258-b619-4f22-9458-dd7addc8c154">
<img width="306" alt="Screenshot 6" src="https://github.com/Ayamainstream/PharmaApp/assets/72498812/4f89b756-d487-4058-bb09-4369cc0cf61b">
<img width="306" alt="Screenshot 7" src="https://github.com/Ayamainstream/PharmaApp/assets/72498812/a8d411bc-2577-49f3-bae5-b2f775c109c9">
<img width="306" alt="Screenshot 8" src="https://github.com/Ayamainstream/PharmaApp/assets/72498812/c960d9da-c00b-4f19-bed1-5d29b341f1f1">
<img width="306" alt="Screenshot 9" src="https://github.com/Ayamainstream/PharmaApp/assets/72498812/3e902180-9c64-4d53-bf51-80cbdf618d7b">

## Technologies Used

- Java: The primary programming language used for developing the PharmaApp Android application.
- Firebase Authentication: Provides secure user authentication and account management functionality.
- Room Database: A local SQLite database used to store drug information and other app-related data.
- ViewModel: Part of the Android Architecture Components, ViewModel manages the app's UI-related data and provides a lifecycle-aware approach.
- LiveData: An observable data holder class that enables the ViewModel to communicate changes to the UI.

## Prerequisites

To build and run the PharmaApp project locally, ensure you have the following prerequisites installed:

- Android Studio: The official integrated development environment (IDE) for Android app development.
- Java Development Kit (JDK): The Java SE Development Kit is required for developing Android apps.

## Getting Started

1. Clone the repository:

```shell
git clone https://github.com/Ayamainstream/PharmaApp.git
```

2. Open the project in Android Studio.

3. Connect your Android device or start an emulator.

4. Build and run the app.

## Configuration

Before running the PharmaApp, make sure to configure the following:

- Firebase: Set up a Firebase project and connect it to the app. Enable Firebase Authentication and follow the necessary steps to configure it in the project.
## Contributing

Contributions to PharmaApp are welcome! If you find any issues or would like to propose new features, please submit a pull request or open an issue in the repository.

## License

The PharmaApp project is licensed under the [MIT License](https://opensource.org/licenses/MIT). See the `LICENSE` file for more details.

## Acknowledgments

Special thanks to the developers who have contributed to the technologies and libraries used in the PharmaApp project.
