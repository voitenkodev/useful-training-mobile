package models

public enum class EquipmentEnum(private val key: String) {
    DUMBBELLS("dumbbells"),
    BARBELL("barbell"),
    EZ_BAR("ez_bar"),
    TRAP_BAR("trap_bar"),
    ROPE("rope"),
    STRAIGHT_BAR("straight_bar"),

    AB_MACHINES("ab_machines"),
    BUTTERFLY("butterfly"),
    BUTTERFLY_REVERSE("butterfly_reverse"),
    LEG_EXTENSION_MACHINES("leg_extension_machines"),
    LEG_CURL_MACHINES("leg_curl_machines"),
    CHEST_PRESS_MACHINES("chest_press_machines"),
    BICEPS_MACHINES("biceps_machines"),
    SMITH_MACHINES("smith_machines"),
    HACK_SQUAT_MACHINES("hack_squat_machines"),
    DEADLIFT_MACHINES("deadlift_machines"),
    SHOULDER_PRESS_MACHINES("shoulder_press_machines"),
    LATERAL_RAISE_MACHINES("lateral_raise_machines"),
    TRICEPS_MACHINES("triceps_machines"),
    CALF_RAISE_MACHINES("calf_raise_machines"),
    GLUTE_MACHINES("glute_machines"),

    LAT_PULLDOWN("lat_pulldown"),
    CABLE("cable"),
    CABLE_CROSSOVER("cable_crossover"),
    ROW_CABLE("row_cable"),

    PULL_UP_BAR("pull_up_bar"),
    DIP_BARS("dip_bars"),
    ROMAIN_CHAIR("romain_chair"),
    GLUTE_HAM_RAISE_BENCH("glute_ham_raise_bench"),

    FLAT_BENCH("flat_bench"),
    ADJUSTABLE_BENCH("adjustable_bench"),
    DECLINE_BENCH("decline_bench"),
    FLAT_BENCH_WITH_RACK("flat_bench_with_rack"),
    INCLINE_BENCH_WITH_RACK("incline_bench_with_rack"),
    DECLINE_BENCH_WITH_RACK("decline_bench_with_rack"),
    SQUAT_RACK("squat_rack"),
    PREACHER_CURL_BENCH("preacher_curl_bench"),
    ROW_BENCH("row_bench"),
    UNKNOWN("unknown");

    override fun toString(): String {
        return key
    }

    public companion object {
        public fun of(key: String?): EquipmentEnum {
            return entries.firstOrNull { it.key == key } ?: UNKNOWN
        }
    }
}