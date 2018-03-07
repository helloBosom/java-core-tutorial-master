package fun.peri.myenum;

enum TrafficLamp{
    RED(20) {
        @Override
        public TrafficLamp nextLamp() {
            return GREEN;
        }
    },
    GREEN(60) {
        @Override
        public TrafficLamp nextLamp() {
            return YELLOW;
        }
    },
    YELLOW(10) {
        @Override
        public TrafficLamp nextLamp() {
            return RED;
        }
    };

    int time;
    TrafficLamp(int time){
        this.time = time;
    }

    public abstract TrafficLamp nextLamp();
}
