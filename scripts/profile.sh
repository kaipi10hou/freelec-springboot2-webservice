#!/usr/bin/env bash

# 쉬고 있는 profile 찾기: real1이 사용중이면 real2가 쉬고있고, 반대면 real1이 쉬고 있음

function find_idle_profile()
{
  RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/profile)

  if [ ${RESPONSE_CODE} -ge 400 ]
  then
    CURRENT_PROFILE=real2 # 현재가 에러 상태면  real1에 배포를 해서 서비스 재실행을 하기 위해 current를 real2로 잡은 것 같다.
  else
    CURRENT_PROFILE=$(curl -s http://localhost/profile) # 현재 프로파일을
  fi

  if [ ${CURRENT_PROFILE} == real1 ]
  then
    IDLE_PROFILE=real2
  else
    IDLE_PROFILE=real1
  fi

  echo "${IDLE_PROFILE}"
}

function find_idle_port()
{
  IDLE_PROFILE=$(find_idle_profile)

  if [ ${IDLE_PROFILE} == real1 ]
  then
    echo "8081"
  else
    echo "8082"
  fi
}