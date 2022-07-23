package net.hermite.chatrp.utils;

public class MinecraftColorCode {
    public static String getColorCode(String color)
    {
        String code_color = "";

        switch(color)
        {
            case "Noir":
                code_color = "§0";
                break;
            case "BleuFonce":
                code_color = "§1";
                break;
            case "VertFonce":
                code_color = "§2";
                break;
            case "AquatiqueSombre":
                code_color = "§3";
                break;
            case "RougeFonce":
                code_color = "§4";
                break;
            case "RoseFonce":
                code_color = "§5";
                break;
            case "Dore":
                code_color = "§6";
                break;
            case "Gris":
                code_color = "§7";
                break;
            case "GrisFonce":
                code_color = "§8";
                break;
            case "Bleu":
                code_color = "§9";
                break;
            case "Vert":
                code_color = "§a";
                break;
            case "Aquatique":
                code_color = "§b";
                break;
            case "Rouge":
                code_color = "§c";
                break;
            case "RoseClair":
                code_color = "§d";
                break;
            case "Jaune":
                code_color = "§e";
                break;
            case "Blanc":
                code_color = "§f";
                break;
            default:
                code_color = "§f";
                break;
        }
        return code_color;
    }
}
