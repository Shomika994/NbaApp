package com.example.customaplication



object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{

        val questionList = ArrayList<Question>()

        val que1 = Question(1, "What city is this team from?", R.drawable.hornets, "San Antonio", "Houston",
            "Atlanta", "Charlotte", 4)

        questionList.add(que1)

        val que2 = Question(2, "What city is this team from?", R.drawable.milwaukee, "Milwaukee", "Boston",
            "Toronto", "Seattle", 1)

        questionList.add(que2)

        val que3 = Question(3, "What city is this team from?", R.drawable.miami_heat_logo, "Oklahoma city", "Denver",
            "Miami", "Cincinnati", 3)

        questionList.add(que3)

        val que4 = Question(4, "What city is this team from?", R.drawable.philadelphia_76ers, "Cleveland", "Philadelphia",
            "Dallas", "Chicago", 2)

        questionList.add(que4)

        val que5 = Question(5, "What city is this team from?", R.drawable.phoenix, "Phoenix", "Vancouver",
            "Portland", "Orlando", 1)

        questionList.add(que5)

        val que6 = Question(6, "What city is this team from?", R.drawable.sacramento, "Detroit", "Sacramento",
            "New York", "Washington", 2)

        questionList.add(que6)

        val que7 = Question(7, "What city is this team from?", R.drawable.spurs, "Indianapolis", "Minneapolis",
            "New Orleans", "San Antonio", 4)

        questionList.add(que7)

        val que8 = Question(8, "What city is this team from?", R.drawable.warriors, "Salt Lake city", "Memphis",
            "San Francisco", "Portland", 3)

        questionList.add(que8)

        return questionList

    }

}