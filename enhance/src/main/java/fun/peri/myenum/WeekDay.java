package fun.peri.myenum;

/**
 * 带有抽象方法的枚举类
 */
public enum WeekDay{
    SUNDAY(0){
        @Override
        public WeekDay nextDay() {
            return MONDAY;
        }
    }, MONDAY(1){
        @Override
        public WeekDay nextDay() {
            return TUESDAY;
        }
    }, TUESDAY(2) {
        @Override
        public WeekDay nextDay() {
            return WEDNESDAY;
        }
    }, WEDNESDAY(3) {
        @Override
        public WeekDay nextDay() {
            return THURSDAY;
        }
    }, THURSDAY(4) {
        @Override
        public WeekDay nextDay() {
            return FRIDAY;
        }
    }, FRIDAY(5) {
        @Override
        public WeekDay nextDay() {
            return SATURDAY;
        }
    }, SATURDAY(6) {
        @Override
        public WeekDay nextDay() {
            return SUNDAY;
        }
    };
    int day;
    WeekDay(int day){
        this.day = day;
    }

    public int day(){
        return day;
    }
    public abstract WeekDay nextDay();
}
