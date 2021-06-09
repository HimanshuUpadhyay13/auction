package services;

import entity.Player;
import entity.Team;
import exceptions.InvalidTeamException;
import exceptions.PlayerNotFoundException;
import mappers.TeamRequestMapper;
import providers.PlayerStorage;
import providers.TeamStorage;
import requests.BuildTeamRequestDTO;
import requests.BuildTeamResponseDTO;
import validators.Validator;

import java.util.ArrayList;
import java.util.List;

public class TeamService {

    private Validator<BuildTeamRequestDTO> validator;
    private TeamRequestMapper teamRequestMapper;

    private TeamStorage teamStorage;

    public TeamService(Validator<BuildTeamRequestDTO> validator, TeamRequestMapper teamRequestMapper,TeamStorage teamStorage) {
        this.validator = validator;
        this.teamRequestMapper = teamRequestMapper;
        this.teamStorage=teamStorage;
    }

    public BuildTeamResponseDTO buildTeam(BuildTeamRequestDTO request) throws InvalidTeamException {
        validator.validate(request);
        Team team = teamRequestMapper.mapFromDTO(request);
        teamStorage.save(team);
        return TeamRequestMapper.mapToDTO(team);
    }


}
