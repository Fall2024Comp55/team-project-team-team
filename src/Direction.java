public enum Direction {
    RIGHT, LEFT, UP, DOWN;
    
    @Override//for some reason this only works if override is there idky
    public String toString() {
        switch(this) {
            case RIGHT: return "RIGHT";
            case LEFT: return "LEFT";
            case UP: return "UP";
            case DOWN: return "DOWN";
            default: return "n/a";
        }
    }
}
