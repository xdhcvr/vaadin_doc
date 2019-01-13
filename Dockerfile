FROM java

#RUN groupadd -r uwsgi && useradd -r -g uwsgi uwsgi
EXPOSE 9090 9191

WORKDIR /target
COPY target /target
COPY entry.sh /

#USER uwsgi

CMD ["/entry.sh"]

