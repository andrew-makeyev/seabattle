package lv.tsi.javaweb.seabattle.model;

public class Player {
    private String name;
    private Field myField = new Field();
    private Field enemyField = new Field();
    private boolean ready;
    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Field getEnemyField() {
        return enemyField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Field getMyField() {
        return myField;
    }
}
