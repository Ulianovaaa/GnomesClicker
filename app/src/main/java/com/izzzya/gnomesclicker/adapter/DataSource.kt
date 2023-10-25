package com.izzzya.gnomesclicker.adapter

import com.izzzya.gnomesclicker.R

data class Extentention(
    val id: Int,
    val img: Int,
    val value: Int,
    val cost: Int
)

data class Skin(
    val id: Int,
    val img: Int,
    val cost: Int
)


class DataSource {
    companion object{
        val skinsList = listOf(
            Skin(
                0,
                R.drawable.gnome1,
                0
            ),
            Skin(
                1,
                R.drawable.gnome2,
                50
            ),
            Skin(
                2,
                R.drawable.gnome3,
                250
            ),
            Skin(
                3,
                R.drawable.gnome4,
                500
            ),
            Skin(
                4,
                R.drawable.gnome5,
                1000
            ),
            Skin(
                5,
                R.drawable.gnome6,
                25000
            ),
        )

        val extList = listOf(
            Extentention(
                0,
                R.drawable.e1,
                2,
                0
            ),
            Extentention(
                1,
                R.drawable.e2,
                3,
                100
            ),
            Extentention(
                2,
                R.drawable.e3,
                5,
                200
            ),
            Extentention(
                3,
                R.drawable.e4,
                10,
                400
            ),
            Extentention(
                4,
                R.drawable.e5,
                20,
                1000
            ),
            Extentention(
                5,
                R.drawable.e6,
                100,
                2000
            ),
        )
    }
}