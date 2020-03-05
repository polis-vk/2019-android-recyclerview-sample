package ru.ok.technopolis.recyclerview.sample;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies;
    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        movies = generateMovieList();
        setContentView(R.layout.activity_main);
        setupRecyclerView();
        setupFloatingButton();
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.activity_main__rv_movies);
        moviesAdapter = new MoviesAdapter(movies, this::onMovieClick);
        recyclerView.setAdapter(moviesAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setupFloatingButton() {
        FloatingActionButton floatingActionButton = findViewById(R.id.activity_main__fb_add);
        floatingActionButton.setOnClickListener(v -> onAddClick());
    }

    private void onMovieClick(Movie movie) {
        Toast.makeText(MainActivity.this, movie.name, Toast.LENGTH_SHORT).show();
    }

    private void onAddClick() {
        movies.add(generateNewMovie());
        moviesAdapter.notifyDataSetChanged();
    }

    private Movie generateNewMovie() {
        return new Movie("Новый фильм!", "Описание добавлю позже", 0);
    }

    private List<Movie> generateMovieList() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Побег из Шоушенка",
                "Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни",
                R.drawable.movie_1));
        movies.add(new Movie("Матрица",
                "Жизнь Томаса Андерсона разделена на две части: днём он — самый обычный офисный работник, получающий нагоняи от начальства, а ночью превращается в хакера по имени Нео, и нет места в сети, куда он не смог бы дотянуться",
                R.drawable.movie_2));
        movies.add(new Movie("Как приручить дракона",
                "Вы узнаете историю подростка Иккинга, которому не слишком близки традиции его героического племени, много лет ведущего войну с драконами",
                R.drawable.movie_3));
        movies.add(new Movie("12 стульев",
                "Во время революции и последовавшего за ней краткого периода военного коммунизма многие прятали свои ценности как можно надежнее",
                R.drawable.movie_4));
        movies.add(new Movie("Зеленая книга",
                "Утонченный светский лев, богатый и талантливый музыкант нанимает в качестве водителя и телохранителя человека, который менее всего подходит для этой работы",
                R.drawable.movie_5));
        movies.add(new Movie("Пираты Карибского моря: Проклятие Черной жемчужины",
                "Жизнь харизматичного авантюриста, капитана Джека Воробья, полная увлекательных приключений, резко меняется, когда его заклятый враг — капитан Барбосса — похищает корабль Джека, Черную Жемчужину, а затем нападает на Порт Ройал и крадет прекрасную дочь губернатора, Элизабет Свонн.",
                R.drawable.movie_6));
        movies.add(new Movie("Гарри Поттер и философский камень",
                "Жизнь десятилетнего Гарри Поттера нельзя назвать сладкой: его родители умерли, едва ему исполнился год, а от дяди и тётки, взявших сироту на воспитание, достаются лишь тычки да подзатыльники",
                R.drawable.movie_7));
        return movies;
    }

}
