# 컨테이너 생성, 실행 (백그라운드 실행, 강제 재생성)
db-up:
	docker-compose up -d --force-recreate

# volume 삭제
db-down:
	docker-comose down -v

