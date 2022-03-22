import java.util.Scanner;
class Fil{
    String name;
    Double god;
    String country;
    String janr;
    Double prokat;
}
public class AboutFilm2 {
    static Scanner sc;
    public static Fil[] setFilm(int count) {
        Scanner sc = new Scanner(System.in);
        Fil[] filmes = new Fil[count];
        for (int i = 0; i < filmes.length; i++) {
            filmes[i] = new Fil();
            System.out.println("Введите название " + (i + 1));
            filmes[i].name = sc.nextLine();

            System.out.println("Год " + (i + 1));
            filmes[i].god = sc.nextDouble();

            sc.nextLine();

            System.out.println("Страна " + (i + 1));
            filmes[i].country = sc.nextLine();

            System.out.println("Жанр " + (i + 1));
            filmes[i].janr = sc.nextLine();

            System.out.println("Стоимость проката " + (i + 1));
            filmes[i].prokat = sc.nextDouble();
            sc.nextLine();
        }
        return filmes;
    }


    public static void showArray(Fil[] filmes) {
        for (int i = 0; i < filmes.length; i++) {
            System.out.println(filmes[i].name + "\t" + filmes[i].god + "\t" + filmes[i].country + "\t"
                    + filmes[i].janr + "\t" + filmes[i].prokat);
        }
    }

    public static void showFilm(Fil film) {
        System.out.println(film.name + "\t" + film.god + "\t" + film.country + "\t"
                + film.janr + "\t" + film.prokat);
    }

    public static void sortGod(Fil[] filmes) {
        for (int i = 0; i < filmes.length - 1; i++) {
            for (int j = 0; j < filmes.length - i - 1; j++) {
                if (filmes[j].god > filmes[j + 1].god) {
                    Fil temp = filmes[j];
                    filmes[j] = filmes[j + 1];
                    filmes[j + 1] = temp;
                }
            }
        }
    }

    public static void sortName(Fil[] filmes) {
        for (int i=0; i<filmes.length-1; i++){
            for (int j = 0; j<filmes.length-i-1; j++) {
                if (filmes[j].name.compareTo(filmes[j+1].name)>0) {
                    Fil temp = filmes[j];
                    filmes[j] = filmes[j+1];
                    filmes[j+1] = temp;
                }
            }
        }
    }

    //min god

    public static int nomMin(Fil[] filmes) {
        int indexMin = 0;
        double minGod = filmes[indexMin].god;
        for (int i=1; i<filmes.length; i++) {
            if (filmes[i].god < minGod) {
                indexMin = i;
                minGod = filmes[indexMin].god;
            }
        }
        return indexMin;
    }

    public static double avgProkat(Fil[] filmes) {
        double sumProkat = 0;
        for (int i = 0; i < filmes.length; i++) {
            sumProkat += filmes[i].prokat;
        }
        double avgProkat = (double) (sumProkat / filmes.length);
        return avgProkat;
    }

    public static Fil[] bigger(Fil[] filmes){
        double avgProkat = avgProkat(filmes);
        int kol = 0;
        for (int i = 0; i < filmes.length; i++){
            if(filmes[i].prokat> avgProkat){
                ++kol;
            }
        }
        if(kol!=0){
            int n = -1;
            Fil[] biggerFilmes = new Fil[kol];
            for (int i = 0; i < filmes.length; i++){
                if(filmes[i].prokat > avgProkat){
                    biggerFilmes[++n] = filmes[i];
                }
            }
            return biggerFilmes;
        }
        else{
            return null;
        }
    }

    public static Fil findForName(Fil filmes[], String searchName) {
        int indexSearch = -1;
        for (int i = 0; i < filmes.length; i++) {
            if (filmes[i].name.equals(searchName)) {
                indexSearch = i;
            }
        }
        if (indexSearch != -1) {
            return filmes[indexSearch];
        } else {
            return null;
        }
    }
    public static void main(String[] args) { // ГЛАВНЫЙ КЛАСС С МЕТОДАМИ
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество фильмов ");
        int n = sc.nextInt(); // количество фильмов
        sc.nextLine();

        Fil filmes[] = setFilm(n); // ввод информации о фильмах

        System.out.println("\nНазвание, год, страна, жанр, прокат ");
        showArray(filmes); // вывод полученной информации

// страна с минимальным значением года
        int nomMin = nomMin(filmes);
        System.out.println("\nФильм с ранним годом выпуска:");
        showFilm(filmes[nomMin]);

// сортировка фильмов по алфавиту
        showArray(filmes);
        System.out.println("\nОтсортированный список по алфавиту:");
        showArray(filmes);

// прокат больше средней
        System.out.println("\nФильмы, с прокатом больше средней ");
        if(bigger(filmes)!=null){
            showArray(bigger(filmes));
        }
        else {
            System.out.println("Нет фильма с прокатом больше средней ");
        }

// поиск фильма
        System.out.println("\n ПОИСК фильма \n Введите название фильма ");
        String searchName = sc.nextLine();
        Fil findResult = findForName(filmes, searchName);
        if (findResult != null) {
            System.out.println("Не найдено");
            System.out.println(findResult.name + "\t" + findResult.god + "\t" + findResult.country +
                    "\t" + findResult.janr + "\t" + findResult.prokat);
            System.out.println("Введите номер поля для редактирования");
            System.out.println("1 - название , 2 - год, 3 - страна, 4 - жанр, 5 - прокат");
            int indexR = sc.nextInt();

            switch (indexR) {
                case 1: {
                    System.out.println("Введите новое имя ");
                    String newName = sc.nextLine();
                    findResult.name = newName;
                    break;
                }
                case 2: {
                    System.out.println("Введите новое значение года ");
                    double newGod = sc.nextDouble();
                    findResult.god = newGod;
                    break;
                }
                case 3: {
                    System.out.println("Введите новую страну ");
                    String newCountry = sc.nextLine();
                    findResult.country = newCountry;
                    break;
                }
                case 4: {
                    System.out.println("Введите новый жанр ");
                    String newJanr = sc.nextLine();
                    findResult.janr = newJanr;
                    break;
                }
                case 5: {
                    System.out.println("Введите новый прокат ");
                    double newProkat = sc.nextDouble();
                    findResult.prokat = newProkat;
                    break;
                }
                default: {
                    System.out.println("Не найдено ");
                    break;
                }
            }
            System.out.println(findResult.name + "\t" + findResult.god + "\t" + findResult.country +
                    "\t" + findResult.janr + "\t" + findResult.prokat);
        }
        else{
            System.out.println("Ничего не найдено ");
        }
    }
}






