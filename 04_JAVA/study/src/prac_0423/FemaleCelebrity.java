package prac_0423;

import java.util.Objects;

public class FemaleCelebrity implements Celebrity {
    private String name;

    public FemaleCelebrity(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FemaleCelebrity that)) return false;
        return Objects.equals(name, that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "여자 연예인: " + name;
    }
}
