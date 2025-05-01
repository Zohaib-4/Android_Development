package com.example.scheduler;

public class TaskDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "task_db";
    private static final int DB_VERSION = 1;

    public TaskDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, datetime LONG, status INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tasks");
        onCreate(db);
    }

    public void insertTask(String title, String description, long datetime) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", title);
        cv.put("description", description);
        cv.put("datetime", datetime);
        cv.put("status", 0); // 0 = upcoming
        db.insert("tasks", null, cv);
    }

    public List<Task> getUpcomingTasks() {
        List<Task> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        long now = System.currentTimeMillis();

        Cursor cursor = db.rawQuery("SELECT * FROM tasks WHERE datetime > ? ORDER BY datetime ASC", new String[]{String.valueOf(now)});
        while (cursor.moveToNext()) {
            Task task = new Task(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getLong(3),
                    cursor.getInt(4)
            );
            list.add(task);
        }
        cursor.close();
        return list;
    }
}
