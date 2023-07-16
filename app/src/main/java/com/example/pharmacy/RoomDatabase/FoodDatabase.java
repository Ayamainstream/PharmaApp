package com.example.pharmacy.RoomDatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.pharmacy.R;

/**
 * 3- Database
 * Connect the model {@link FoodRoom} with {@link FoodDao} in this class
 * to initialize the database
 */
@Database(entities = {FoodRoom.class}, version = 1, exportSchema = false)
public abstract class FoodDatabase extends RoomDatabase {

    private static FoodDatabase instance;

    public abstract FoodDao foodDao();

    /**
     * To make sure we just have on instance of our database every time
     * to save memory and for more efficient
     * this function has "synchronized" to set only one thread at a time can access this method
     * for avoiding making more than one object at the same time
     *
     * @param context
     * @return
     */
    public static synchronized FoodDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FoodDatabase.class, "drug_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static Callback roomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    /**
     * Put to initial data to our database
     */
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private FoodDao foodDao;

        private PopulateDbAsyncTask(FoodDatabase db) {
            foodDao = db.foodDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            foodDao.insert(new FoodRoom("Парацетамол",
                    "Таблетки белого или белого с кремоватым оттенком цвета, плоскоцилиндрические, с риской и фаской.",
                    1499, R.drawable.paracetamol));

            foodDao.insert(new FoodRoom("Болеутоляющее",
                    "Временно снижает лихорадку и облегчает незначительные боли, связанные с головной болью, зубной болью.",
                    5590, R.drawable.painrelief));

            foodDao.insert(new FoodRoom("Цитрамон",
                    "Препарат оказывает умеренное болеутоляющее и жаропонижающее действие.",
                    2500, R.drawable.citramon));

            foodDao.insert(new FoodRoom("Нурофен",
                    "Нурофен Экспресс быстро всасывается и легко расщепляется в организме, помогая быстро облегчить боль.",
                    2459, R.drawable.nurofen));

            foodDao.insert(new FoodRoom("Ибупрофен",
                    "Таблетки следует проглатывать, запивая водой, желательно во время или после еды. Не принимайте чаще, чем через 4 часа.",
                    3799, R.drawable.ibuprofen));
            return null;
        }
    }
}
