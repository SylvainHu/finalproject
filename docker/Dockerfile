# Use a specific node version that matches your Angular project's requirements
FROM node:20.12.2

# Create and set the working directory inside the container
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# Add the node_modules/.bin directory to the PATH environment variable
ENV PATH /usr/src/app/node_modules/.bin:$PATH

# Copy package.json and package-lock.json if available to the working directory
COPY package.json package-lock.json* ./

# Install the dependencies defined in package.json
RUN npm install

# Copy the entire application code to the working directory in the container
COPY . .

# Expose port 4200 to allow external access
EXPOSE 4200

# Start the Angular application using ng serve, accessible from all network interfaces
CMD ["npm", "run", "start"]
