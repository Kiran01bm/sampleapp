FROM node:carbon

# App workdir
WORKDIR /usr/src/apps/searchwebapp

# Copy package.json + package-lock.json
COPY package*.json ./

# Install the app
RUN npm install

# Copy application src
COPY . .

# Expose app on port http/80
EXPOSE 80

# Boot up the App
CMD [ "npm", "start" ]
