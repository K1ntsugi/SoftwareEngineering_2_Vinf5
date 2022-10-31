public class Antragsprozess {
    public static void main(String[] args) {
        new Antragsteller().stelleAntrag();
    }
}

class Antragsteller {
    public void stelleAntrag() {
        Antrag erstattungsAntrag = new Antrag();

        for (int i = 0; i < 10; i++) {
            if (hasMoreUnbetragteLeistungen())
                erstattungsAntrag.tryAddLeistung(getNextLeistung());
        }

        var sum = erstattungsAntrag.getSumLeistungen();
        if (sum <= 1000)
            erstattungsAntrag.cancel();
        else
            erstattungsAntrag.submit();

        if (Math.random() <= 0.5)
            erstattungsAntrag.setBemerkung("Bemerkung");
    }

    private boolean hasMoreUnbetragteLeistungen() {
        return false;
    }

    private Leistung getNextLeistung() {
        return null;
    }
}

class Antrag {
    public Antrag() {
    }

    public void tryAddLeistung(Leistung leistung) {
        var ret = Versicherung.isErstattbar(leistung);
        if (ret)
            addLeistung(leistung);
    }

    private void addLeistung(Leistung leistung) {
    }

    public double getSumLeistungen() {
        return 0;
    }

    public void setBemerkung(String bemerkung) {
    }

    public void submit() {
    }

    public void cancel() {
    }
}

class Leistung {
}

class Versicherung {
    public static boolean isErstattbar(Leistung leistung) {
        return false;
    }
}