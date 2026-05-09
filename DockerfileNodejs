FROM node AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .

from node AS final
WORKDIR /app
copy --from=builder /app /app
CMD ["npm","start"]
