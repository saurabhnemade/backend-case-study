import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get("/partner")
  async getPartner() {
    return this.appService.getPartner();
  }

  @Get("/order")
  async getOrder() {
    return this.appService.getOrder();
  }
}
