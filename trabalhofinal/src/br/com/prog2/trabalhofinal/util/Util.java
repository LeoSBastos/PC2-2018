package br.com.prog2.trabalhofinal.util;

import java.time.LocalDate;

public class Util {
	public static LocalDate formatarDataDeGuiParaLocalDate(String dataGui) {
		int[] dataFormatada = new int[3];
		dataFormatada[0] = Integer.parseInt(dataGui.substring(0, 2));
		dataFormatada[1] = Integer.parseInt(dataGui.substring(3, 5));
		dataFormatada[2] = Integer.parseInt(dataGui.substring(6, 10));
		return LocalDate.of(dataFormatada[2], dataFormatada[1], dataFormatada[1]);
	}

	public static String formatarDataDeLocalDateParaGui(LocalDate dataLocalDate) {
		StringBuilder dataFormatada = new StringBuilder();
		if (dataLocalDate.getDayOfMonth() < 10) {
			dataFormatada.append("0" + dataLocalDate.getDayOfMonth() + "/");
		} else {
			dataFormatada.append(dataLocalDate.getDayOfMonth() + "/");
		}
		if (dataLocalDate.getMonthValue() < 10) {
			dataFormatada.append("0" + dataLocalDate.getMonthValue() + "/");
		} else {
			dataFormatada.append(dataLocalDate.getMonthValue() + "/");
		}
		dataFormatada.append(dataLocalDate.getYear());
		return dataFormatada.toString();
	}

	public static Integer formatarGuiParaTipoTelefone(String dataGui) {
		Integer tipoTelefone = 0;
		if (dataGui.equals("Fixo")) {
			tipoTelefone = 0;
		} else if (dataGui.equals("Movel")) {
			tipoTelefone = 1;
		}
		return tipoTelefone;
	}

	public static String formatarTipoTelefoneParaGui(Integer dataTelefone) {
		String tipoTelefone = null;
		switch (dataTelefone) {
		case 0:
			tipoTelefone = "Fixo";
			break;
		case 1:
			tipoTelefone = "Movel";
			break;
		}
			return tipoTelefone;
	}
	public static Integer formatarGuiParaEstado(String dataGui) {
		Integer tipoTelefone = 0;
		if (dataGui.equals("Reservado")) {
			tipoTelefone = 0;
		} else if (dataGui.equals("Hospedado")) {
			tipoTelefone = 1;
		}
		return tipoTelefone;
	}

	public static String formatarEstadoParaGui(Integer dataTelefone) {
		String tipoTelefone = null;
		switch (dataTelefone) {
		case 0:
			tipoTelefone = "Reservado";
			break;
		case 1:
			tipoTelefone = "Hospedado";
			break;
		}
		return tipoTelefone;
	}
}
