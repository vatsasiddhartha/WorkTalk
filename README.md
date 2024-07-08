

https://github.com/vatsasiddhartha/WorkTalk/assets/92005541/7bdebd06-a501-437d-b7e8-12a166dd37c3

# WorkTalk

WorkTalk is an Android application designed to facilitate communication among users by allowing them to post questions and share answers. The app integrates with Firebase Realtime Database to store and retrieve data, ensuring real-time updates and a seamless user experience.

## Features

- **User Authentication**: Secure user authentication using Firebase Authentication.
- **Post Questions**: Users can post their questions, which will be stored in the Firebase Realtime Database.
- **View Questions**: Users can view questions posted by other users in a feed similar to social media platforms.
- **Answer Questions**: Users can click on a question to navigate to an answer page where they can provide their answers.
- **Real-Time Updates**: All data interactions are handled in real-time using Firebase Realtime Database.



## Installation

1. **Clone the Repository**
    ```bash
    git clone https://github.com/your-username/WorkTalk.git
    ```
2. **Open in Android Studio**
    - Open Android Studio.
    - Click on `File -> Open` and select the cloned repository folder.

3. **Add Firebase to Your Project**
    - Go to the [Firebase Console](https://console.firebase.google.com/).
    - Create a new project or use an existing one.
    - Add an Android app to your project.
    - Download the `google-services.json` file.
    - Place the `google-services.json` file in the `app` directory of your Android project.

4. **Update Dependencies**
    - Ensure your `build.gradle` files have the necessary Firebase dependencies. Here is an example:
    ```gradle
    // Project-level build.gradle
    buildscript {
        dependencies {
            classpath 'com.google.gms:google-services:4.3.10'
        }
    }

    // App-level build.gradle
    dependencies {
        implementation 'com.google.firebase:firebase-auth:21.0.1'
        implementation 'com.google.firebase:firebase-database:20.0.3'
        implementation 'com.google.firebase:firebase-analytics:19.0.0'
    }

    apply plugin: 'com.google.gms.google-services'
    ```

5. **Run the Application**
    - Connect your Android device or start an emulator.
    - Click `Run` in Android Studio.

## Usage

### Posting a Question

1. Navigate to the `QuestionFragment`.
2. Enter your question in the provided `EditText`.
3. Click the `Submit` button to post your question to the Firebase Realtime Database.

### Viewing and Answering Questions

1. Navigate to the `PostFragment`.
2. A list of questions posted by different users will be displayed.
3. Click on a question to navigate to the `AnswerActivity` where you can provide your answer.

## Code Overview

### Main Classes and Their Functions

- **MainActivity**: The entry point of the app, responsible for setting up navigation.
- **HomeFragment**: Displays the home screen with navigation to various features.
- **QuestionFragment**: Allows users to post questions.
- **PostFragment**: Displays a list of questions from different users.
- **AnswerActivity**: Allows users to answer a specific question.

### Adapters

- **QuestionsAdapter**: Binds question data to the `RecyclerView` in the `HomeFragment`.
- **MyItemRecyclerViewAdapter**: Binds question data to the `RecyclerView` in the `PostFragment`.

### Models

- **Questions**: Data model for a question, includes fields for `id` and `text`.

### Firebase Integration

- **Firebase Realtime Database**: Used for storing and retrieving questions in real-time.
- **Firebase Authentication**: Used for user authentication (if implemented).

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes.
4. Commit your changes (`git commit -m 'Add some feature'`).
5. Push to the branch (`git push origin feature-branch`).
6. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or feedback, please feel free to reach out.

