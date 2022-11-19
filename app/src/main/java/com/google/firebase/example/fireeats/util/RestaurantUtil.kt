package com.google.firebase.example.fireeats.util

import android.content.Context
import com.google.firebase.example.fireeats.R
import com.google.firebase.example.fireeats.model.Restaurant

import java.util.Arrays
import java.util.Random

/**
 * Utilities for Restaurants.
 */
object RestaurantUtil {

    private const val COMPUTADOR_URL_FMT = "https://assets.stickpng.com/images/588524d86f293bbfae451a31.png"

    private val NAME_FIRST_WORDS = arrayOf(
            "HP", "Asus", "Lenovo", "Acer", "Xiaomi", "Samsung", "Dell", "Sony", "Huawei")

    private val NAME_SECOND_WORDS = arrayOf(
            "Core i5", "Core i7", "Core i3", "AMD Ryzen 3", "AMD Ryzen 5", "AMD Ryzen 7", "Core i9")

    /**
     * Create a random Restaurant POJO.
     */
    fun getRandom(context: Context): Restaurant {
        val restaurant = Restaurant()
        val random = Random()

        // Cities (first elemnt is 'Any')
        var cities = context.resources.getStringArray(R.array.cities)
        cities = Arrays.copyOfRange(cities, 1, cities.size)


        val prices = intArrayOf(1, 2, 3)

        restaurant.name = getRandomName(random)
        restaurant.city = getRandomString(cities, random)
        restaurant.photo = COMPUTADOR_URL_FMT
        restaurant.price = getRandomInt(prices, random)
        restaurant.numRatings = random.nextInt(20)

        // Note: average rating intentionally not set

        return restaurant
    }



    /**
     * Get price represented as dollar signs.
     */
    fun getPriceString(restaurant: Restaurant): String {
        return getPriceString(restaurant.price)
    }

    /**
     * Get price represented as dollar signs.
     */
    fun getPriceString(priceInt: Int): String {
        when (priceInt) {
            1 -> return "$"
            2 -> return "$$"
            3 -> return "$$$"
            else -> return "$$$"
        }
    }

    private fun getRandomName(random: Random): String {
        return (getRandomString(NAME_FIRST_WORDS, random) + " " +
                getRandomString(NAME_SECOND_WORDS, random))
    }

    private fun getRandomString(array: Array<String>, random: Random): String {
        val ind = random.nextInt(array.size)
        return array[ind]
    }

    private fun getRandomInt(array: IntArray, random: Random): Int {
        val ind = random.nextInt(array.size)
        return array[ind]
    }
}
