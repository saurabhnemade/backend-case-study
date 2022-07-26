FROM node:18-alpine

WORKDIR /home/nodejs-server

COPY package.json package-lock.json ./
COPY tsconfig.json tsconfig.build.json nest-cli.json ./
RUN npm install

COPY src ./src

RUN npm run build
#RUN npm run start:prod

USER 1000

CMD [ "node", "dist/main.js" ]
