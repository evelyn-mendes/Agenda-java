package com.evelyn.project.agenda;

public class Agenda {
    
    private String[][][] compromissos = new String[12][31][8];

    public void retornarTabelaOpc() {
        System.out.println("==================================== Sua Agenda ====================================");
        System.out.println("1 - Para adicionar um compromisso\n2 - Para consulta compromisso\n0 - Para sair");
    }

    public void adicionarCompromisso (int mes, int dia, int hora, String compromisso) {

        this.compromissos[mes][dia][hora] = compromisso;
    }

    public String getCompromissos(int mes, int dia, int hora) {

        int mesVisivel = mes ++;
        int diaVisivel = dia ++;
        int horaVisivel = hora++;
        if(compromissos[mes][dia][hora] == null) {
            compromissos[mes][dia][hora] = "Nada Agendado";
        }

        return "\n|\tCompromisso do mês " + mesVisivel + " no dia " + diaVisivel + " às " + horaVisivel + " horas: " + compromissos[mes][dia][hora] + "\t|\n";
    }

    public String consultarCompromissosMes (int mes) {

        String compromisso = "";
        for(int i = mes; i < compromissos.length; i++) {

            for(int j = 0; j < compromissos[i].length; j++) {

                for(int k = 0; k < compromissos[i][j].length; k++) {

                    if(compromissos[i][j][k] != null) {

                        compromisso += "\n|\tCompromisso do mês " + (i+1) + " no dia " + (j+1) + " às " + (k+1) + " horas: " + compromissos[i][j][k] + "\t|\n";
                    }
                }
            }
        }

        return compromisso;
    }

    public String consultarCompromissosDia (int dia) {

        String compromisso = "";

        for(int i = 0; i < compromissos.length; i++) {

            for(int j = dia; j < compromissos[i].length; j++) {

                for(int k = 0; k < compromissos[i][j].length; k++) {

                    if(compromissos[i][j][k] != null) {

                        compromisso += "\n| Compromisso do dia " + (j+1) + " às " + (k+1) + " horas: " + compromissos[i][j][k] + " |\n";
                    }
                }
            }
        }

        return compromisso;
    }
}
