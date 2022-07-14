import { Injectable } from '@nestjs/common';
import axios from 'axios';

@Injectable()
export class AppService {
  async getPartner() {

    var config = {
      method: 'get',
      url: `${process.env.JAVA_SERVER}/partner`,
      headers: {
        'Content-Type': 'application/json'
      }
    };

    let serverResponse = await axios(config)
    return serverResponse.data;
  }

  async getOrder() {

    var config = {
      method: 'get',
      url: `${process.env.JAVA_SERVER}/order`,
      headers: {
        'Content-Type': 'application/json'
      }
    };

    let serverResponse = await axios(config)
    return serverResponse.data;
  }
}
