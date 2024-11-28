# MyRecipe App - Android Application

**MyRecipe App** is an Android application built using **Kotlin**, **Room Database**, and **Retrofit**. The app fetches data from the **TheMealDB API** to allow users to discover meals, save their favorite recipes, search for meals, and watch YouTube recipe videos. The app also features a smart search mechanism that prevents redundant API calls when the search query remains the same.

## Features

- 🍲 **Discover Meals**: Browse through a list of popular meals.
- 💾 **Save Favorite Meals**: Save meals to your favorites for later access.
- 🔍 **Smart Search**: Search for meals, with optimization to avoid frequent redundant API calls. The app waits before making a new request if the user is typing quickly.
- 📺 **Recipe Videos**: Navigate to YouTube for cooking video tutorials for each meal.
- 🛠️ **Room Database**: Used for storing favorite meals locally.
- 🥘 **Search Meals**: Type in a search query to find meals and their recipes.

## Technologies Used

- **Kotlin**: The primary programming language for developing the app.
- **Room Database**: For storing and managing the user’s favorite meals offline.
- **Retrofit**: A type-safe HTTP client for Android to fetch meal data from **TheMealDB API**.
- **MVVM Architecture**: Ensures a clean separation of concerns and improves code scalability and testability.
- **LiveData & ViewModel**: For lifecycle-aware UI updates.
- **YouTube API**: For opening the video tutorials of each meal.

## Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/Aditya-Giri1234/MyRecipeApp.git
