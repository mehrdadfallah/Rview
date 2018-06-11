package com.mehrdadfallah.rview;



        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Environment;
        import android.support.annotation.Nullable;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.widget.LinearLayout;

        import java.io.File;
        import java.util.ArrayList;
        import java.util.List;

public class ListFile extends Activity {


    private List<File> list = new ArrayList<>();
    private RecyclerView list2;
    private File file;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_file);
        configureView();
        configureList();
        Bundle bundle = getIntent().getBundleExtra("shortcut");
        String string = bundle.getString("Name");


        file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
//
        File[] files = file.listFiles();
        for (int j=0 ; j<files.length ; j++){
            list.add(files[j]);
        }
    }

    private void configureList() {
        ListFileAdapter listFileAdapter = new ListFileAdapter(list );
        list2.setLayoutManager(new LinearLayoutManager(ListFile.this));
        list2.setAdapter(listFileAdapter);
    }

    private void configureView() {
        list2 = (RecyclerView) findViewById(R.id.file_list);
    }
}
