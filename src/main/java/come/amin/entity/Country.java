package come.amin.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "country_id")
    private int countryId;
    @Basic
    @Column(name = "country_name")
    private String countryName;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "country")
    private List<Location>locations;

    public Country(String countryName) {
        this.countryName = countryName;
    }

    public Country() {
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (countryId != country.countryId) return false;
        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null) return false;

        return true;
    }

    public void addLocation(Location location){
        if (locations==null){
            locations=new ArrayList<>();
        }
        locations.add(location);
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }
}
