package it.pkg.service;

import javax.jms.TextMessage;

import it.pkg.bean.DataMessageObject;

public interface BasicMdbService {

  void iniciarService(DataMessageObject datosProgramarCambioCiclo, TextMessage textMessage, String messageID);
}
