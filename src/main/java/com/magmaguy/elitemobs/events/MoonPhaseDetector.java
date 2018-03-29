/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.magmaguy.elitemobs.events;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class MoonPhaseDetector {

    public static moonPhase detectMoonPhase(World eventWorld) {

        int days = (int) eventWorld.getFullTime() / 24000;
        int phase = days % 8;

        switch (phase) {

            case 0:
                return moonPhase.FULL_MOON;
            case 1:
                return moonPhase.WANING_GIBBOUS;
            case 2:
                return moonPhase.LAST_QUARTER;
            case 3:
                return moonPhase.WANING_CRESCENT;
            case 4:
                return moonPhase.NEW_MOON;
            case 5:
                return moonPhase.WAXING_CRESCENT;
            case 6:
                return moonPhase.FIRST_QUARTER;
            case 7:
                return moonPhase.WAXING_GIBBOUS;
            default:
                Bukkit.getLogger().info("Unhandled moon phase.");
                return null;

        }


    }

    public enum moonPhase {

        FULL_MOON,
        WANING_GIBBOUS,
        LAST_QUARTER,
        WANING_CRESCENT,
        NEW_MOON,
        WAXING_CRESCENT,
        FIRST_QUARTER,
        WAXING_GIBBOUS

    }

}
