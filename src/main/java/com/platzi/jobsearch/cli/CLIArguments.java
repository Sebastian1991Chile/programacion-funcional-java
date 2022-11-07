package com.platzi.jobsearch.cli;

import com.beust.jcommander.Parameter;

// Clase para poder recibir los argumentos de JCommander
public final class CLIArguments {
    CLIArguments(){

    }

    @Parameter(
            required = true,
            descriptionKey = "name",
            validateWith = CLINameValidator.class,
            description = "name"
    )
    private String name;

    @Parameter(
            names = {"--species", "-s"},
            description = "Cada búsqueda puede ser según especie"
    )
    private String species;

    @Parameter(
            names = {"--gender", "-g"},
            description = "Cada búsqueda puede ser según género"
    )
    private String gender;

    @Parameter(
            names = {"--origin", "-o"},
            description = "Cada búsqueda puede ser según planeta de origen"
    )
    private String origin;

    @Parameter(
            names = "--is-alive",
            description = "Agregar si queremos personajes vivos"
    )
    private boolean isAlive = false;

    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Mostrar ayuda de comandos"
    )
    private boolean isHelp;

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getOrigin() {
        return origin;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", gender='" + gender + '\'' +
                ", origin='" + origin + '\'' +
                ", isAlive=" + isAlive +
                ", isHelp=" + isHelp +
                '}';
    }

    public static CLIArguments newInstance(){
        return new CLIArguments();
    }
}
