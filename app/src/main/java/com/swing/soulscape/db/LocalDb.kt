package com.swing.soulscape.db

import com.swing.soulscape.R
import com.swing.soulscape.db.models.PreferModel

object LocalDb {
    fun generatePreferList(): List<PreferModel> {
        return listOf(
            PreferModel(id = 0, image = R.drawable.prefer_theme, status = false),
            PreferModel(
                id = 1,
                name = "Manage my anxiety",
                image = R.drawable.prefer_one,
                status = false
            ),
            PreferModel(
                id = 2,
                name = "Control my anger",
                image = R.drawable.prefer_two,
                status = false
            ),
            PreferModel(
                id = 3,
                name = "Deal with mood swings",
                image = R.drawable.prefer_three,
                status = false
            ),
            PreferModel(
                id = 4,
                name = "Sleep better",
                image = R.drawable.prefer_four,
                status = false
            ),
            PreferModel(
                id = 5,
                name = "Stay focussed",
                image = R.drawable.prefer_five,
                status = false
            ),
            PreferModel(
                id = 6,
                name = "Be more active",
                image = R.drawable.prefer_six,
                status = false
            ),
            PreferModel(
                id = 7,
                name = "Live happier",
                image = R.drawable.prefer_seven,
                status = false
            ),
        )
    }
}
