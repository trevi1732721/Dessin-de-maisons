import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage stage1){
        stage1.setWidth(800);
        stage1.setHeight(400);
        stage1.setTitle("Dessin de maison!!!!");

        Rectangle fond1 = new Rectangle(400,400);
        fond1.setFill(Color.LIGHTGRAY);
        Rectangle fond2 = new Rectangle(400,0,400,400);
        fond2.setFill(Color.BLACK);
        Group maison1 = Maison(1.0,50,160);
        DropShadow ombre = new DropShadow(4,-10,10,Color.GRAY);
        maison1.setEffect(ombre);
        Group maison2 = Maison(1.0,450,160);
        Group oiseau1 = Oiseau(0.8,20,90);
        Group oiseau2 = Oiseau(0.8,140,40);
        Group soleil = Soleil(1.4,320,75);
        Text jour = new Text(156,310,"Jour");
        jour.setFont(new Font(36));
        Text nuit = new Text(557,310,"Nuit");
        nuit.setFill(Color.WHITE);
        nuit.setFont(new Font(36));
        Group etoile1 = Étoile(0.55,0.4,2,480,50);
        Group etoile2 = Étoile(0.3,0.2,1.5,520,115);
        Group etoile3 = Étoile(0.55,0.4,1,570,75);
        Group etoile4 = Étoile(0.7,0.5,2.1,640,100);
        Circle lune = new Circle(745,60,28);
        Stop[] moon= new Stop[]{
                new Stop(0,Color.WHITE),
                new Stop(1,Color.BLACK),
        };
        LinearGradient moon2 = new LinearGradient(
                0,0,
                1,1,
                true,
                CycleMethod.NO_CYCLE,
                moon
        );
        lune.setFill(moon2);

        Group groupe1 = new Group(fond1,fond2,maison1,oiseau1,oiseau2,soleil,jour,maison2,nuit,etoile1,etoile2,etoile3,etoile4,lune);

        stage1.setScene(
                new Scene(groupe1)
        );

        stage1.show();
    }
    public Group Étoile(double larg,double haut, double temps,double x, double y){
        Polygon étoile = new Polygon(0,-50,18,22,-26,-25,26,-25,-18,22,0,-50);
        étoile.setScaleX(larg);
        étoile.setScaleY(haut);
        étoile.setFill(Color.YELLOW);
        FadeTransition etoileFade = new FadeTransition(Duration.seconds(temps),étoile);
        etoileFade.setFromValue(1);
        etoileFade.setToValue(0);
        etoileFade.setAutoReverse(true);
        etoileFade.setCycleCount(Timeline.INDEFINITE);
        etoileFade.play();
        Group etoile = new Group(étoile);
        etoile.setTranslateY(y);
        etoile.setTranslateX(x);
        return etoile;
    }
    public Group Oiseau(double taille,double x, double y){
        QuadCurve aileG = new QuadCurve(0,40,25,25,50,50);
        aileG.setFill(Color.TRANSPARENT);
        aileG.setStroke(Color.BLACK);
        QuadCurve aileD = new QuadCurve(50,50,75,25,100,40);
        aileD.setFill(Color.TRANSPARENT);
        aileD.setStroke(Color.BLACK);

        Timeline vol = new Timeline();
        vol.setCycleCount(Timeline.INDEFINITE);
        KeyValue kvG1 = new KeyValue(aileG.startYProperty(),60);
        KeyValue kvG2 = new KeyValue(aileG.startYProperty(),30);
        KeyValue kvG3 = new KeyValue(aileG.startYProperty(),40);
        KeyValue kvG4 = new KeyValue(aileG.endYProperty(),45);
        KeyValue kvG5 = new KeyValue(aileG.endYProperty(),55);
        KeyValue kvG6 = new KeyValue(aileG.endYProperty(),50);
        KeyValue kvD4 = new KeyValue(aileD.startYProperty(),45);
        KeyValue kvD5 = new KeyValue(aileD.startYProperty(),55);
        KeyValue kvD6 = new KeyValue(aileD.startYProperty(),50);
        KeyValue kvD1 = new KeyValue(aileD.endYProperty(),60);
        KeyValue kvD2 = new KeyValue(aileD.endYProperty(),30);
        KeyValue kvD3 = new KeyValue(aileD.endYProperty(),40);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(1),kvG1,kvD1,kvG4,kvD4);
        KeyFrame kf2 = new KeyFrame(Duration.seconds(2),kvG2,kvD2,kvG5,kvD5);
        KeyFrame kf3 = new KeyFrame(Duration.seconds(2.5),kvG3,kvD3,kvD6,kvG6);
        vol.getKeyFrames().addAll(kf1,kf2,kf3);
        vol.play();

        Group ailes= new Group(aileG,aileD);
        ailes.setScaleX(taille);
        ailes.setScaleY(taille);
        ailes.setTranslateY(y);
        ailes.setTranslateX(x);
        return ailes;
    }
    public Group Soleil(double taille,double x, double y){
        Line rayon1 = new Line(0,-25,0,-50);
        rayon1.setStroke(Color.YELLOW);
        rayon1.setStrokeWidth(0.5);
        Line rayon2 = new Line(25,0,50,0);
        rayon2.setStroke(Color.YELLOW);
        rayon2.setStrokeWidth(0.5);
        Line rayon3 = new Line(-25,0,-50,0);
        rayon3.setStroke(Color.YELLOW);
        rayon3.setStrokeWidth(0.5);
        Line rayon4 = new Line(0,25,0,50);
        rayon4.setStroke(Color.YELLOW);
        rayon4.setStrokeWidth(0.5);
        Line rayon5 = new Line(20,20,30,30);
        rayon5.setStroke(Color.YELLOW);
        rayon5.setStrokeWidth(0.5);
        Line rayon6 = new Line(-20,-20,-30,-30);
        rayon6.setStroke(Color.YELLOW);
        rayon6.setStrokeWidth(0.5);
        Line rayon7 = new Line(20,-20,30,-30);
        rayon7.setStroke(Color.YELLOW);
        rayon7.setStrokeWidth(0.5);
        Line rayon8 = new Line(-20,20,-30,30);
        rayon8.setStroke(Color.YELLOW);
        rayon8.setStrokeWidth(0.5);
        Circle soleil = new Circle(0,0,20);
        soleil.setFill(Color.YELLOW);
        FillTransition change = new FillTransition(Duration.seconds(4),soleil);
        change.setToValue(Color.ORANGE);
        change.setCycleCount(Timeline.INDEFINITE);
        change.setAutoReverse(true);
        change.play();

        Group soleilTot = new Group(rayon1,rayon2,rayon3,rayon4,rayon5,rayon6,rayon7,rayon8,soleil);
        Timeline tourner = new Timeline();
        tourner.setCycleCount(Timeline.INDEFINITE);
        KeyValue kv1 = new KeyValue(soleilTot.rotateProperty(),360);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(5),kv1);
        tourner.getKeyFrames().add(kf1);
        tourner.play();

        soleilTot.setScaleY(taille);
        soleilTot.setScaleX(taille);
        soleilTot.setTranslateY(y);
        soleilTot.setTranslateX(x);

        return soleilTot;
    }
    public Group Maison(double taille,double x, double y){
        Rectangle fenêtre = new Rectangle(145,55,27,17);
        fenêtre.setFill(Color.AQUA);
        fenêtre.setStroke(Color.GRAY);
        Line vert = new Line(159,55,159,72);
        vert.setStroke(Color.GRAY);
        Line hor = new Line(145,64,171,64);
        hor.setStroke(Color.GRAY);
        Group fenetre =  new Group(fenêtre,vert,hor);

        Polygon toit = new Polygon(44,0,88,40,0,40,44,0);
        toit.setTranslateX(96);
        toit.setTranslateY(10);
        toit.setFill(Color.BROWN);

        Rectangle structure = new Rectangle(100,50,80,40);
        structure.setFill(Color.BEIGE);

        Rectangle porte = new Rectangle(112,65,15,25);
        porte.setFill(Color.SADDLEBROWN);

        Circle poingne = new Circle(123,80,2);
        poingne.setFill(Color.YELLOWGREEN);

        Group maison = new Group(structure,fenetre,toit,porte,poingne);
        maison.setScaleY(taille);
        maison.setScaleX(taille);
        maison.setTranslateY(y);
        maison.setTranslateX(x);
        return maison;
    }
}