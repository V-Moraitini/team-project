package airvita.nexus.persistanceLayer;

class BlankMCO extends Blank {
private MCOType type;

public BlankMCO(String number, MCOType type) {
        super(number);
        this.type = type;
        }

public MCOType getMCOType() {
        return type;
        }

@Override
public BlankType getType() {
        return BlankType.MCO;
        }

@Override
public String toString() {
        return "BlankMCO [number=" + getNumber() + ", assigned=" + isAssigned() + ", type=" + type + "]";
        }
        }


// Enumeration of MCO types
enum MCOType {
    EXCESS_LUGGAGE,
    OTHER_MISC
}
