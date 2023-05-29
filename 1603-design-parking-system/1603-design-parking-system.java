class ParkingSystem {
    int b = 0;
    int m = 0;
    int s = 0;
    public ParkingSystem(int big, int medium, int small) {
        b = big;
        m = medium;
        s = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1) {
            return --b >= 0;
        }
        else if(carType == 2) {
            return --m >= 0;
        }
        else {
            return --s >= 0;
        }
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */