package br.com.anapaula.automation.test.datamass;

public enum States {
    ALABAMA("Alabama"),
    ALASKA("Alaska"),
    ARIZONA("Arizona"),
    ARKANSAS("Arkansas"),
    CALIFORNIA("California");

    private String name;

    States(String name) {
        this.name = name;
    }
    public String getNome() {
        return name;
    }

}
