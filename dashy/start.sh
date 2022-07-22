docker run -d   -p 8080:80 -v ~/BD4NRG/dashy/logo_sticky.png:/app/public/logo.png  -v ~/BD4NRG/dashy/conf.yml:/app/public/conf.yml    --name my-dashboard   --restart=always   lissy93/dashy:latest
