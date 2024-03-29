package com.casper.testdrivendevelopment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookListMainActivity extends AppCompatActivity {
   private List<Book> ListBooks=new ArrayList<>();
    ListView booklistview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_main);
        init();
        BookAdapter adapter = new BookAdapter(
                BookListMainActivity.this, R.layout.list_view_item_book, ListBooks);
        booklistview=((ListView) findViewById(R.id.list_view_books));
        booklistview.setAdapter(adapter);

    }

    private void init() {
        ListBooks.add(new Book("软件项目管理案例教程（第4版）", R.drawable.book_2));
        ListBooks.add(new Book("创新工程实践", R.drawable.book_no_name));
        ListBooks.add(new Book("信息安全数学基础（第2版）", R.drawable.book_1));
    }

    public List<Book> getListBooks() {
        return ListBooks;
    }

    public class BookAdapter extends ArrayAdapter<Book> {

        private int resourceId;

        public BookAdapter(Context context, int resource, List<Book> objects) {
            super(context, resource, objects);
            resourceId = resource;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Book book = getItem(position);//获取当前项的实例
            View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            ((ImageView) view.findViewById(R.id.image_view_book_cover)).setImageResource(book.getCoverResourceId());
            ((TextView) view.findViewById(R.id.text_view_book_title)).setText(book.getTitle());
            return view;
        }

    }
}
